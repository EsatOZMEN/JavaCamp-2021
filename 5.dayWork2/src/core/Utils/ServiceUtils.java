package core.Utils;

import java.util.ArrayList;
import java.util.List;

import core.Utils.result.Result;

public class ServiceUtils {
	public static Result[] runValidates(Result...results) {
		List<Result> resultList= new ArrayList<Result>();
		for (Result result : resultList) {
			if(!result.isSuccess()) {resultList.add(result);
		}
		
	}
		
		return resultList.toArray(new Result[resultList.size()]);

	}

	public static Result[] runChecks(Result...results) {
		return runValidates(results);
	}


}
