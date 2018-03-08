package ruxing.demo.core.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

import java.util.Date;

/**
 * Created by ruxing on 12/12/2017.
 */

public class MyElasticJob implements SimpleJob {

    public static Integer index = 0;

    public void execute(ShardingContext context) {
                index++;
                switch (context.getShardingItem()) {
                    case 0:
                        System.out.println("result : " + index + " time : " + new Date() + " sharding item: 0");
                        break;
                    case 1:
                        System.out.println("result : " + index + " time : " + new Date() + " sharding item: 1");
                        break;
                }
        }
}
