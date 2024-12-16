create or replace
    procedure movie_add_proc(
    i_movie_id integer,
    i_movie_name char,
    i_movie_type char,
    i_other_name char,
    i_movie_year integer,
    i_description text,
    i_movie_length integer,
    i_poster_url char,
    i_kp_raiting double precision,
    i_genres char)

as $$
declare
    is_exists integer;

begin
    select
        count(1)
    into
        is_exists
    from
        movie_list
    where
            movie_id = i_movie_id;

    if is_exists > 0
    then
        raise exception 'Movie (movie_id=%) already exists ',
            i_movie_id;
    end if;

    insert
    into
        movie_list (movie_id,
                    movie_name,
                    movie_type,
                    is_watched)
    values (i_movie_id,
            i_movie_name,
            i_movie_type,
            0);

    insert
    into
        movie_properties (movie_id,
                          other_name,
                          description,
                          movie_year,
                          movie_length,
                          poster_url,
                          kp_raiting,
                          genres)
    values (i_movie_id,
            i_other_name,
            i_description,
            i_movie_year,
            i_movie_length,
            i_poster_url,
            i_kp_raiting,
            i_genres);
end;

$$ language plpgsql;
