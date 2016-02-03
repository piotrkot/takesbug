package com.github.piotrkot;

import java.io.IOException;
import org.takes.Take;
import org.takes.facets.fork.FkRegex;
import org.takes.facets.fork.TkFork;
import org.takes.http.Exit;
import org.takes.http.FtBasic;
import org.takes.rq.RqForm;
import org.takes.rs.RsHTML;
import org.takes.rs.RsVelocity;

/**
 * Bug.
 * @author Piotr Kotlicki (piotr.kotlicki@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class Bug {
    /**
     * Main runnable method.
     * @param args Arguments.
     */
    public static void main(final String... args) throws IOException {
        new FtBasic(
            new TkFork(
                new FkRegex(
                    "/",
                    new RsHTML(Bug.class.getResourceAsStream("/bootstrap.html"))
                ),
                new FkRegex(
                    "/form",
                    new RsHTML(Bug.class.getResourceAsStream("/form.html"))
                ),
                new FkRegex(
                    "/hello",
                    (Take) req -> new RsVelocity(
                        "Hi, ${user}!",
                        new RsVelocity.Pair(
                            "user",
                            new RqForm.Base(req).param("user").iterator().next()
                        )
                    )
                )
            ),
            8080
        ).start(Exit.NEVER);
    }
}
