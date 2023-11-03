package com.example.reportservice.data;

import java.time.Month;
import java.util.Map;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
public class Statistic {
    @Id
    private String id;
    @Indexed(unique = true)
    private String username;
    private Map<Integer, Map<Month, Integer>> yearMonthStatistic;

}
