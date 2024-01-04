package paginationandsorting.service.impl;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import paginationandsorting.model.Countries;
import paginationandsorting.repo.CountryRepository;
import paginationandsorting.service.CountryService;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

  private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    //method to paginate and sort acc to id(default),countryName or countryPopulation
    @Override
    public List<Countries> findPaginated(Integer pageNo, Integer pageSize,String sortBy,String orderBy) {

        Sort sortOrder = Sort.by(sortBy);
        //if orderBy is desc then descending otherwise by default ascending
        if(orderBy.equals("desc")) {
            sortOrder = Sort.by(sortBy).descending();
        }

        Pageable paging = PageRequest.of(pageNo, pageSize,sortOrder);
        Page<Countries> pagedResult = countryRepository.findAll(paging);
        return pagedResult.toList();
    }

}
