import cn.sparke.support.modules.v1.exam.bean.submit.dto.RightOption;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/8/31 16:49
 */
public class java8 {
    @Test
    public void lambda() {
        List<RightOption> list = new ArrayList<>();
        list.add(null);
        Map<String, String> rightOptionMap  = list.stream().collect(Collectors.toMap(RightOption::getSubQuestionId, RightOption::getRightOptionId));
        System.out.printf("111");
    }
}
