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
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StatisticService {

    private final StatisticRepository statisticRepository;

    @Transactional
    public void updateStatistic(InvitationStatisticRequest invitationStatisticRequest) {
        String username = invitationStatisticRequest.getUsername();
        int year = invitationStatisticRequest.getDate().getYear();
        Month month = invitationStatisticRequest.getDate().getMonth();

        Statistic statistic = statisticRepository.findByUsername(username)
              .orElse(Statistic.builder()
                    .username(username)
                    .yearMonthStatistic(new HashMap<>())
                    .build());

        Map<Integer, Map<Month, Integer>> yearMonthStatistic = statistic.getYearMonthStatistic();
        yearMonthStatistic.computeIfAbsent(year, k -> new HashMap<>())
              .merge(month, 1, Integer::sum);

        statisticRepository.save(statistic);
    }

    public Statistic getStatisticByUsername(String username) {
        return statisticRepository.findByUsername(username)
              .orElseThrow(() -> new UserNotFoundException(
                    "Statistic for user with username: " + username + " not found"));
    }
}
