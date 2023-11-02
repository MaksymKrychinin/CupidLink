package com.example.reportservice.service;

import com.example.reportservice.data.InvitationStatisticRequest;
import com.example.reportservice.data.Statistic;
import com.example.reportservice.exception.UserNotFoundException;
import com.example.reportservice.repository.StatisticRepository;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatisticService {

    private final StatisticRepository statisticRepository;

    public void updateStatistic(InvitationStatisticRequest invitationStatisticRequest) {
        Long userId = invitationStatisticRequest.getUserId();
        int year = invitationStatisticRequest.getDate().getYear();
        Month month = invitationStatisticRequest.getDate().getMonth();

        Statistic statistic = statisticRepository.findByUserId(userId)
              .orElse(Statistic.builder()
                    .userId(userId)
                    .yearMonthStatistic(new HashMap<>())
                    .build());

        Map<Integer, Map<Month, Integer>> yearMonthStatistic = statistic.getYearMonthStatistic();
        yearMonthStatistic.computeIfAbsent(year, k -> new HashMap<>())
              .merge(month, 1, Integer::sum);

        statisticRepository.save(statistic);
    }

    public Statistic getStatisticByUserId(Long userId) {
        return statisticRepository.findByUserId(userId)
              .orElseThrow(() -> new UserNotFoundException(
                    "Statistic for user with id " + userId + " not found"));
    }
}
