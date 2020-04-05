package test.gl51.movie.service.impl

import gl51.movie.service.impl.MovieClientImpl
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class MovieClientImplTest extends Specification
{
    @Inject
    MovieClientImpl client = Mock()

    // On test si l'injection a bien fonctionnée
    void "injection should work"()
    {
        expect:
            client != null
    }
}
