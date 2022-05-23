package com.epam.springdatademo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Author author;
    private LocalDate releaseDate;

    public Book() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id)
                && Objects.equals(name, book.name)
                && Objects.equals(author, book.author)
                && Objects.equals(releaseDate, book.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, releaseDate);
    }

    @Override
    public String toString() {
        return "Book{"
                + "id="
                + id
                + ", name='"
                + name
                + '\''
                + ", author="
                + author
                + ", releaseDate="
                + releaseDate
                + '}';
    }

    public Book(Long id, String name, Author author, LocalDate releaseDate) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.releaseDate = releaseDate;
    }
}
