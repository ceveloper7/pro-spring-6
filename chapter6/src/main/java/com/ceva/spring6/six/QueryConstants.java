package com.ceva.spring6.six;

public enum QueryConstants {
    ;
    public static final String FIND_BY_FIRST_NAME = "select id, first_name, last_name, birth_date from singer where first_name = :first_name";
    public static final String FIND_BY_ID = "select id, first_name, last_name, birth_date from singer where id = :singer_id";
    // empleamos un namedParameter :singerId
    public static final String NAMED_FIND_NAME = "select CONCAT(first_name , ' ' , last_name) from singer where id = :singerId";
    public static final String PARAMETRIZED_FIND_NAME = "select CONCAT(first_name , ' ' , last_name) from singer where id = ?";
    public static final String FIND_NAME = "select first_name, last_name from singer where id=";

    public static final String SIMPLE_INSERT = "insert into singer (first_name, last_name, birth_date) values (?, ?, ?)";
    public static final String SIMPLE_DELETE = "delete from singer where id=?";
    public static final String ALL_SELECT = "select * from singer";
    public static final String ALL_JOIN_SELECT = "select s.id, s.first_name, s.last_name, s.birth_date, "+
            "a.id AS album_id, a.title, a.release_date " +
            "from singer s " +
            "right join album a on s.id = a.singer_id";

    public static final String UPDATE_SINGER = "update singer set first_name=:first_name, last_name=:last_name, birth_date=:birth_date where id=:id";

    public static final String INSERT_SINGER = "insert into singer (first_name, last_name, birth_date) values (:first_name, :last_name, :birth_date)";

    public static final String INSERT_SINGER_ALBUM = "insert into album (singer_id, title, release_date) values (:singer_id, :title, :release_date)";
    public static final String FIND_SINGER_ALBUM = "SELECT s.singer_id, s.first_name, s.last_name, s.birth_date" +
            ", a.album_id AS album_id, a.title, a.release_date FROM singer s " +
            "LEFT JOIN album a ON s.singer_id = a.singer_id";
}
