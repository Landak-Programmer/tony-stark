package asia.fourtitude.java.sboot.tonystark.common;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class PageRequestBuilder {

    /**
     * Default page number. 0 means first page.
     */
    private final static int DEFAULT_PAGE_NUMBER = 0;

    /**
     * Number of elements in a page.
     */
    private final static int DEFAULT_PAGE_SIZE = 10;
    private final static int MAX_PAGE_SIZE = 25;

    public static PageRequest getPageRequest(Integer pageSize, Integer pageNumber, String sortingCriteria) {
        Set<String> sortingFileds = new LinkedHashSet<>(Arrays.asList(StringUtils.split(StringUtils.defaultIfEmpty(sortingCriteria, ""), ",")));
        List<Sort.Order> sortingOrders = sortingFileds
                .stream()
                .map(PageRequestBuilder::getOrder)
                .collect(Collectors.toList());
        Sort sort = sortingOrders.isEmpty() ? Sort.unsorted() : Sort.by(sortingOrders);
        pageNumber = getPageNumber(pageNumber);
        pageSize = getPageSize(pageSize);

        return PageRequest.of(
                pageNumber,
                pageSize,
                sort);
    }

    private static Integer getPageNumber(Integer pageNumber) {
        if (pageNumber == null || pageNumber <= 0) {
            return DEFAULT_PAGE_NUMBER;
        }
        return pageNumber - 1;
    }

    private static Integer getPageSize(Integer pageSize) {
        if (pageSize == null || pageSize <= 0) {
            return DEFAULT_PAGE_SIZE;
        }
        return pageSize > MAX_PAGE_SIZE ? MAX_PAGE_SIZE : pageSize;
    }

    private static Sort.Order getOrder(String value) {
        if (StringUtils.startsWith(value, "-")) {
            return new Sort.Order(Sort.Direction.DESC, StringUtils.substringAfter(value, "-"));
        } else if (StringUtils.startsWith(value, "+")) {
            return new Sort.Order(Sort.Direction.ASC, StringUtils.substringAfter(value, "+"));
        } else {
            return new Sort.Order(Sort.Direction.ASC, StringUtils.trim(value));
        }
    }

}
