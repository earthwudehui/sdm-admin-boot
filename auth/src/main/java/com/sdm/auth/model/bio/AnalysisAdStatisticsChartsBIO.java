package com.sdm.auth.model.bio;

import lombok.Data;

@Data
public class AnalysisAdStatisticsChartsBIO {

    /**
     * x轴字段
     */
    private String xField;

    /**
     * y轴字段
     */
    private String yField;

    /**
     * 拆分字段，在分组柱状图下同 groupField、colorField，在堆积柱状图下同 stackField、colorField。 自定义
     */
    private String seriesField;
}
