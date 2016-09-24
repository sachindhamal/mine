
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
 * "NeapolitanPizzaDS" static data source (a17d172f-6cb5-45f5-a9c7-27e943c11189)
 */
public class NeapolitanPizzaDS implements Datasource<NeapolitanPizzaDSSchemaItem>, Count,
            Pagination<NeapolitanPizzaDSSchemaItem>, Distinct {

    private static final int PAGE_SIZE = 20;

    private SearchOptions searchOptions;

    public static NeapolitanPizzaDS getInstance(SearchOptions searchOptions){
        return new NeapolitanPizzaDS(searchOptions);
    }

    private NeapolitanPizzaDS(SearchOptions searchOptions){
        this.searchOptions = searchOptions;
    }

    @Override
    public void getItems(Listener<List<NeapolitanPizzaDSSchemaItem>> listener) {
        listener.onSuccess(NeapolitanPizzaDSItems.ITEMS);
    }

    @Override
    public int getPageSize(){
        return PAGE_SIZE;
    }

    @Override
    public void getItem(String id, Listener<NeapolitanPizzaDSSchemaItem> listener) {
        final int pos = Integer.parseInt(id);
        if(NeapolitanPizzaDSItems.ITEMS.size() <= pos){
        	listener.onSuccess(new NeapolitanPizzaDSSchemaItem());
        }
        else {
	        NeapolitanPizzaDSSchemaItem dc = NeapolitanPizzaDSItems.ITEMS.get(pos);
	        if( dc != null)
	            listener.onSuccess(dc);
	        else
	            listener.onFailure(new IllegalArgumentException("NeapolitanPizzaDSSchemaItem not found: " + pos));
	    }
    }

    @Override public int getCount(){
        return NeapolitanPizzaDSItems.ITEMS.size();
    }

    @Override
    public void getItems(int pagenum, Listener<List<NeapolitanPizzaDSSchemaItem>> listener) {
        int first = pagenum * PAGE_SIZE;
        int last = first + PAGE_SIZE;
        ArrayList<NeapolitanPizzaDSSchemaItem> result = new ArrayList<NeapolitanPizzaDSSchemaItem>();
        List<NeapolitanPizzaDSSchemaItem> filteredList = applySearchOptions(NeapolitanPizzaDSItems.ITEMS);
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

    private List<NeapolitanPizzaDSSchemaItem> applySearchOptions(List<NeapolitanPizzaDSSchemaItem> result) {
        List<NeapolitanPizzaDSSchemaItem> filteredList = result;

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

    private List<NeapolitanPizzaDSSchemaItem> applySearch(List<NeapolitanPizzaDSSchemaItem> items, String searchText) {
        List<NeapolitanPizzaDSSchemaItem> filteredList = new ArrayList<>();

        for (NeapolitanPizzaDSSchemaItem item : items) {
                        
            if (FilterUtils.searchInString(item.id, searchText) ||
            FilterUtils.searchInString(item.type, searchText) ||
            FilterUtils.searchInString(item.discription, searchText))
            {
                filteredList.add(item);
            }
        }

        return filteredList;

    }

    private List<NeapolitanPizzaDSSchemaItem> applyFilters(List<NeapolitanPizzaDSSchemaItem> items, List<Filter> filters) {
        List<NeapolitanPizzaDSSchemaItem> filteredList = new ArrayList<>();

        for (NeapolitanPizzaDSSchemaItem item : items) {
            if (
                FilterUtils.applyFilters("id", item.id, filters) &&
                FilterUtils.applyFilters("type", item.type, filters) &&
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
        List<NeapolitanPizzaDSSchemaItem> filteredList = applySearchOptions(NeapolitanPizzaDSItems.ITEMS);
        listener.onSuccess(mapItems(filteredList, columnName));
    }

    private List<String> mapItems(List<NeapolitanPizzaDSSchemaItem> items, String columnName){
        // return only unique values
        ArrayList<String> res = new ArrayList();
        for (NeapolitanPizzaDSSchemaItem item: items){
            String mapped = mapItem(item, columnName);
            if(mapped != null && !res.contains(mapped))
                res.add(mapped);
        }

        return res;
    }

    private String mapItem(NeapolitanPizzaDSSchemaItem item, String columnName){
        // get fields
        switch (columnName){
                        
            case "id":
                return item.id;
            
            case "type":
                return item.type;
            
            case "discription":
                return item.discription;
            default:
               return null;
        }
    }
}


