package com.github.joraclista.douJobListingsApplication.server;

import com.github.joraclista.douJobListingsApplication.client.DouJobListingsApplicationService;
import com.github.joraclista.douJobListingsApplication.shared.JobVacancy;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//@Slf4j
public class DouJobListingsApplicationServiceImpl extends RemoteServiceServlet implements DouJobListingsApplicationService {



    public List<JobVacancy> getJobs(String city, String category) {

        try {
            Document doc = Jsoup.connect("https://jobs.dou.ua/vacancies/?city=%D0%9A%D0%B8%D0%B5%D0%B2&category=Java").get();
            Elements vacanciesList = doc.select("div[id='vacancyListId'] ul li");

            return vacanciesList.stream()
                    .map(element -> {
                        Elements title = element.select("div.title");
                        Elements shInfo = element.select("div.sh-info");

                        return JobVacancy.builder()
                                .company(title.select("a[href].company").text())
                                .info(shInfo.text())
                                .url(title.select("a[href].vt").attr("href"))
                                .position(title.select("a[href].vt").text())
                                .cities(title.select("span.cities").text())
                                .build();
                    })
                    .collect(Collectors.toList());

        } catch (Exception e) {}
        return Collections.EMPTY_LIST;
    }

}