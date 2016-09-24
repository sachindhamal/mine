
package com.ibm.mobileappbuilder.pizzamania20160924080158.ds;

import ibmmobileappbuilder.ds.Count;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ds.Distinct;
import ibmmobileappbuilder.ds.Pagination;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import ibmmobileappbuilder.util.FilterUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * "IndianpizzaDS" static data source (db52f012-68da-4574-a0ff-d446763d91ec)
 */
public class IndianpizzaDS implements Datasource<IndianpizzaDSSchemaItem>, Count,
            Pagination<IndianpizzaDSSchemaItem>, Distinct {

    private static final int PAGE_SIZE = 20;

    private SearchOptions searchOptions;

    public static IndianpizzaDS getInstance(SearchOptions searchOptions){
        return new IndianpizzaDS(searchOptions);
    }

    private IndianpizzaDS(SearchOptions searchOptions){
        this.searchOptions = searchOptions;
    }

    @Override
    public void getItems(Listener<List<IndianpizzaDSSchemaItem>> listener) {
        listener.onSuccess(IndianpizzaDSItems.ITEMS);
    }

    @Override
    public int getPageSize(){
        return PAGE_SIZE;
    }

    @Override
    public void getItem(String id, Listener<IndianpizzaDSSchemaItem> listener) {
        final int pos = Integer.parseInt(id);
        if(IndianpizzaDSItems.ITEMS.size() <= pos){
        	listener.onSuccess(new IndianpizzaDSSchemaItem());
        }
        else {
	        IndianpizzaDSSchemaItem dc = IndianpizzaDSItems.ITEMS.get(pos);
	        if( dc != null)
	            listener.onSuccess(dc);
	        else
	            listener.onFailure(new IllegalArgumentException("IndianpizzaDSSchemaItem not found: " + pos));
	    }
    }

    @Override public int getCount(){
        return IndianpizzaDSItems.ITEMS.size();
    }

    @Override
    public void getItems(int pagenum, Listener<List<IndianpizzaDSSchemaItem>> listener) {
        int first = pagenum * PAGE_SIZE;
        int last = first + PAGE_SIZE;
        ArrayList<IndianpizzaDSSchemaItem> result = new ArrayList<IndianpizzaDSSchemaItem>();
        List<IndianpizzaDSSchemaItem> filteredList = applySearchOptions(IndianpizzaDSItems.ITEMS);
        if(first < filteredList.size())
            for (int i = first; (i < last) && (i < filteredList.size()); i++)
                result.add(filteredList.get(i));

        listener.onSuccess(result);
    }

    @Override
    public void onSearchTextChanged(String s){
        searchOptions.setSearchText(s);
    }

    @Override
    public void addFilter(Filter filter){
        searchOptions.addFilter(filter);
    }

    @Override
    public void clearFilters() {
        searchOptions.setFilters(null);
    }

    private List<IndianpizzaDSSchemaItem> applySearchOptions(List<IndianpizzaDSSchemaItem> result) {
        List<IndianpizzaDSSchemaItem> filteredList = result;

        //Searching options
        String searchText = searchOptions.getSearchText();

        if(searchOptions.getFixedFilters() != null)
            filteredList = applyFilters(filteredList, searchOptions.getFixedFilters());

        if(searchOptions.getFilters() != null)
            filteredList = applyFilters(filteredList, searchOptions.getFilters());

        if (searchText != null && !"".equals(searchText))
            filteredList = applySearch(filteredList, searchText);

        //Sorting options
        Comparator comparator = searchOptions.getSortComparator();
        if (comparator != null) {
            if (searchOptions.isSortAscending()) {
                Collections.sort(filteredList, comparator);
            } else {
                Collections.sort(filteredList, Collections.reverseOrder(comparator));
            }
        }

        return filteredList;
    }

    private List<IndianpizzaDSSchemaItem> applySearch(List<IndianpizzaDSSchemaItem> items, String searchText) {
        List<IndianpizzaDSSchemaItem> filteredList = new ArrayList<>();

        for (IndianpizzaDSSchemaItem item : items) {
                        
            if (FilterUtils.searchInString(item.id, searchText) ||
            FilterUtils.searchInString(item.types, searchText) ||
            FilterUtils.searchInString(item.discription, searchText))
            {
                filteredList.add(item);
            }
        }

        return filteredList;

    }

    private List<IndianpizzaDSSchemaItem> applyFilters(List<IndianpizzaDSSchemaItem> items, List<Filter> filters) {
        List<IndianpizzaDSSchemaItem> filteredList = new ArrayList<>();

        for (IndianpizzaDSSchemaItem item : items) {
            if (
                FilterUtils.applyFilters("id", item.id, filters) &&
                FilterUtils.applyFilters("types", item.types, filters) &&
                FilterUtils.applyFilters("picture", item.picture, filters) &&
                FilterUtils.applyFilters("price", item.price, filters) &&
                FilterUtils.applyFilters("discription", item.discription, filters)
                ){

                filteredList.add(item);
            }
        }

        return filteredList;
    }

    // Distinct interface

    @Override
    public void getUniqueValuesFor(String columnName, Listener<List<String>> listener) {
        List<IndianpizzaDSSchemaItem> filteredList = applySearchOptions(IndianpizzaDSItems.ITEMS);
        listener.onSuccess(mapItems(filteredList, columnName));
    }

    private List<String> mapItems(List<IndianpizzaDSSchemaItem> items, String columnName){
        // return only unique values
        ArrayList<String> res = new ArrayList();
        for (IndianpizzaDSSchemaItem item: items){
            String mapped = mapItem(item, columnName);
            if(mapped != null && !res.contains(mapped))
                res.add(mapped);
        }

        return res;
    }

    private String mapItem(IndianpizzaDSSchemaItem item, String columnName){
        // get fields
        switch (columnName){
                        
            case "id":
                return item.id;
            
            case "types":
                return item.types;
            
            case "discription":
                return item.discription;
            default:
               return null;
        }
    }
}


