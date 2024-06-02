package com.workintech.spring_store.dto;


//Bura da api den gelen istek sonucun da geriye ne döndüreceğimizi gösteriyoruz.
//Örnekte kitabın id'si , ismi, ve categorisi gösteriliyor.
public record BookResponse(long id, String bookName, String categoryName) {

}
