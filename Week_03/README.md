学习笔记
Java代码递归模板
	public void recur(int level,int param){
        //terminator 终止条件
        if(level>MAX_LEVEL){
         return;
        }
        //process current logic 处理当前层逻辑
        process(level,param);

        //drill down 到下一层
        recur(level+1,param);

        //restore current status 清理当前层
    }
递归思维要点
	1.抵制人肉递归
	2.找最近重复性
	3.数学归纳法思维
Java代码分治模板
	private static int divide_conquer(Problem problem, ) {
	  //terminator 终止条件
	  if (problem == NULL) {
	    int res = process_last_result();
	    return res;     
	  }
	  subProblems = split_problem(problem)
	  //conquer subproblems 处理子问题
	  res0 = divide_conquer(subProblems[0])
	  res1 = divide_conquer(subProblems[1])
	  //生成最终结果
	  result = process_result(res0, res1);
	  
	  return result;
	}