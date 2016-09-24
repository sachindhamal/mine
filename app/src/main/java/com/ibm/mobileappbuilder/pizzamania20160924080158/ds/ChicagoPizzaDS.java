
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
 * "ChicagoPizzaDS" static data source (09de794f-3034-4623-bb1f-07f3822ee8fd)
 */
public class ChicagoPizzaDS implements Datasource<ChicagoPizzaDSSchemaItem>, Count,
            Pagination<ChicagoPizzaDSSchemaItem>, Distinct {

    private static final int PAGE_SIZE = 20;

    private SearchOptions searchOptions;

    public static ChicagoPizzaDS getInstance(SearchOptions searchOptions){
        return new ChicagoPizzaDS(searchOptions);
    }

    private ChicagoPizzaDS(SearchOptions searchOptions){
        this.searchOptions = searchOptions;
    }

    @Override
    public void getItems(Listener<List<ChicagoPizzaDSSchemaItem>> listener) {
        listener.onSuccess(ChicagoPizzaDSItems.ITEMS);
    }

    @Override
    public int getPageSize(){
        return PAGE_SIZE;
    }

    @Override
    public void getItem(String id, Listener<ChicagoPizzaDSSchemaItem> listener) {
        final int pos = Integer.parseInt(id);
        if(ChicagoPizzaDSItems.ITEMS.size() <= pos){
        	listener.onSuccess(new ChicagoPizzaDSSchemaItem());
        }
        else {
	        ChicagoPizzaDSSchemaItem dc = ChicagoPizzaDSItems.ITEMS.get(pos);
	        if( dc != null)
	            listener.onSuccess(dc);
	        else
	            listener.onFailure(new IllegalArgumentException("ChicagoPizzaDSSchemaItem not found: " + pos));
	    }
    }

    @Override public int getCount(){
        return ChicagoPizzaDSItems.ITEMS.size();
    }

    @Override
    public void getItems(int pagenum, Listener<List<ChicagoPizzaDSSchemaItem>> listener) {
        int first = pagenum * PAGE_SIZE;
        int last = first + PAGE_SIZE;
        ArrayList<ChicagoPizzaDSSchemaItem> result = new ArrayList<ChicagoPizzaDSSchemaItem>();
        List<ChicagoPizzaDSSchemaItem> filteredList = applySearchOptions(ChicagoPizzaDSItems.ITEMS);
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

    private List<ChicagoPizzaDSSchemaItem> applySearchOptions(List<ChicagoPizzaDSSchemaItem> result) {
        List<ChicagoPizzaDSSchemaItem> filteredList = result;

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

    private List<ChicagoPizzaDSSchemaItem> applySearch(List<ChicagoPizzaDSSchemaItem> items, String searchText) {
        List<ChicagoPizzaDSSchemaItem> filteredList = new ArrayList<>();

        for (ChicagoPizzaDSSchemaItem item : items) {
                        
            if (FilterUtils.searchInString(item.id, searchText) ||
            FilterUtils.searchInString(item.type, searchText) ||
            FilterUtils.searchInString(item.discription, searchText))
            {
                filteredList.add(item);
            }
        }

        return filteredList;

    }

    private List<ChicagoPizzaDSSchemaItem> applyFilters(List<ChicagoPizzaDSSchemaItem> items, List<Filter> filters) {
        List<ChicagoPizzaDSSchemaItem> filteredList = new ArrayList<>();

        for (ChicagoPizzaDSSchemaItem item : items) {
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
        List<ChicagoPizzaDSSchemaItem> filteredList = applySearchOptions(ChicagoPizzaDSItems.ITEMS);
        listener.onSuccess(mapItems(filteredList, columnName));
    }

    private List<String> mapItems(List<ChicagoPizzaDSSchemaItem> items, String columnName){
        // return only unique values
        ArrayList<String> res = new ArrayList();
        for (ChicagoPizzaDSSchemaItem item: items){
            String mapped = mapItem(item, columnName);
            if(mapped != null && !res.contains(mapped))
                res.add(mapped);
        }

        return res;
    }

    private String mapItem(ChicagoPizzaDSSchemaItem item, String columnName){
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


