学习笔记
HashMap总结
	//put 方法 调用putVal方法
	public V put(K key, V value) {
	        return putVal(hash(key), key, value, false, true);
	}
    /**
     * Implements Map.put and related methods
     *
     * @param hash hash for key
     * @param key the key
     * @param value the value to put
     * @param onlyIfAbsent if true, don't change existing value  //onlyIfAbsent为true时 不改变已存在的value
     * @param evict if false, the table is in creation mode. //evict为false时,able是初始化
     * @return previous value, or null if none
     */
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
    	//tab为Node数组,p为临时节点,n为tab长度
        Node<K,V>[] tab; Node<K,V> p; int n, i;
		//如果tab为空或者n为0
        if ((tab = table) == null || (n = tab.length) == 0)
        	//初始化tab长度
            n = (tab = resize()).length;
        //若当前index对应的节点为null 没有发生hash碰撞
        if ((p = tab[i = (n - 1) & hash]) == null)
        	//创建新节点
            tab[i] = newNode(hash, key, value, null);
        else {//发生了hash碰撞
            Node<K,V> e; K k;
			//如果hash相等,key也相等,覆盖value
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            //否则 p是TreeNode对象的话 e从TreeNode中取值
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            //否则  遍历链表
            else {
            	//遍历到尾部,追加新节点到尾部
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        //如果追加节点后 链表数量》=8 则转化为红黑树
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    //如果找到了hash相等 key相等的节点 则覆盖
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            //如果e不是null 说明是覆盖操作
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        //如果不是覆盖操作 操作数+1
        ++modCount;
        //size+1并判断是否需要扩容。
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
	/**
     * Returns the value to which the specified key is mapped,
     * or {@code null} if this map contains no mapping for the key.
     *
     * <p>More formally, if this map contains a mapping from a key
     * {@code k} to a value {@code v} such that {@code (key==null ? k==null :
     * key.equals(k))}, then this method returns {@code v}; otherwise
     * it returns {@code null}.  (There can be at most one such mapping.)
     *
     * <p>A return value of {@code null} does not <i>necessarily</i>
     * indicate that the map contains no mapping for the key; it's also
     * possible that the map explicitly maps the key to {@code null}.
     * The {@link #containsKey containsKey} operation may be used to
     * distinguish these two cases.
     *
     * @see #put(Object, Object)
     */
    public V get(Object key) {
        Node<K,V> e;
        //以key为条件 找到返回value。没找到返回null
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }
    总结:简单的分析了HashMap的put和get方法。
    put方法据key找到是否有存在的元素,如果有,则覆盖值;如果没有,则创建新元素。
    get方法就是getNode,逻辑是和put中根据key找元素一致的。
