package lk.sonali_bookshop.asset.item.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MainCategory {
    EXERCISE_BOOKS("Exercise Books"),
    EDUCATIONAL_PUBLICATIONS("Educational Publications"),
    BOOK_GENRES("Book Genres"),
    NEWS_PAPERS("News Papers"),
    MAGAZINES("Magazines"),
    PAPERS("Papers"),
    EQUIPMENTS("Equipments");


    private final String mainCategory;
}
