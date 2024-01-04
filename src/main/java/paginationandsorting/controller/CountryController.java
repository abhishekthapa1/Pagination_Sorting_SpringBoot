package paginationandsorting.controller;

import org.springframework.web.bind.annotation.*;
import paginationandsorting.model.Countries;
import paginationandsorting.service.impl.CountryServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    private final CountryServiceImpl countryService;

    public CountryController(CountryServiceImpl countryService) {
        this.countryService = countryService;
    }

    //http://localhost:8080/api/country/list/0/5?orderBy=desc&sortBy=countryPopulation --> sort by descending
   // http://localhost:8080/api/country/list/0/5 --> sort by id ascending
    //http://localhost:8080/api/country/list/0/5?orderBy=asc&sortBy=countryPopulation-->sort by asc for population


    @GetMapping("/list/{pageNo}/{pageSize}")
    public List<Countries> getPaginatedCountries(@PathVariable("pageNo") int pageNo,
                                                 @PathVariable("pageSize") int pageSize,
                                                 @RequestParam(required = false) String sortBy,
                                                 @RequestParam(required = false) String orderBy) {
        if (sortBy == null || sortBy.isEmpty()) {
            sortBy = "id";
        }
        if (orderBy == null || orderBy.isEmpty()) {
            orderBy = "asc";
        }
        return countryService.findPaginated(pageNo, pageSize, sortBy, orderBy);
    }
}
