package test.gl51.movie.service.impl

import gl51.movie.data.Movie
import gl51.movie.service.MovieClient
import gl51.movie.service.MovieRegistry
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class MovieClientImplTest extends Specification
{
    @Inject
    MovieClient client = Mock()

    @Inject
    MovieRegistry registry

    // On test si l'injection a bien fonctionnée
    void "injection should work"()
    {
        expect:
            client != null
            registry != null
    }

    void "Mock should work"()
    {
        when:
            registry.addMovieToFavorites("bbbb")
        then:
            client.getMovieDetail(registry.listFavorites().get(0).imdbID) != null
    }
}
