package paginationandsorting.service;

import paginationandsorting.model.Countries;

import java.util.List;

public interface CountryService {

    //pagination and sorting by id(default),name,population and order by asc or desc
    List<Countries> findPaginated(Integer pageNo, Integer pageSize, String sortBy, String orderBy);

}
