package Services;

import Models.Company;
import Models.Order;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CompanyService {


    static List<Company> companyList = new ArrayList<>();
    static Map<Company, List<Order>> companyMap = new HashMap<>();

    public void addCompany(Company company) {
        companyList.add(company);
        companyMap.put(company, company.companyOrderList);
    }

    public void getCompanyDetail(Company company) {
        Map<Object, List<Integer>> result = company.getOneCompanyMap().entrySet().stream()
                .collect(Collectors.toMap(elem -> elem.getKey().getFullName(), elem -> elem.getValue().stream()
                        .map(Order::getTotalAmount).collect(Collectors.toList())));

        result.entrySet().forEach(entry -> System.out.println(entry.getKey() + " " + new ArrayList<>(entry.getValue())));
    }

    public void getSectorFromFilteredCompanies(Double value, String month) {
        for (Company company : companyList) {
            OrderService.getAverageOfOrdersFromOneCompany(company, value, month);
        }
    }


}
