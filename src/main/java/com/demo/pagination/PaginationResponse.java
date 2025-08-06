package com.demo.pagination;

import java.util.List;

public class PaginationResponse<T> {
    private List<T> content;
    private int totalPages;
    private long totalElements;
    private int size;
    private boolean last;  
    private int numberOfElements;
    
    public PaginationResponse() {
		
	}

	

    public PaginationResponse(List<T> content, int totalPages, long totalElements, int size, boolean last, int numberOfElements) {
        this.content = content;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.size = size;
        this.last = last;
        this.numberOfElements = numberOfElements;
    }

    // Getters & Setters
    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isLast() { 
        return last;
    }

    public void setLast(boolean last) {  
        this.last = last;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }
}
