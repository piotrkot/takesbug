package com.github.piotrkot;

import java.io.IOException;
import org.takes.facets.fork.FkRegex;
import org.takes.facets.fork.TkFork;
import org.takes.http.Exit;
import org.takes.http.FtBasic;
import org.takes.rs.RsHTML;

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
                    )
                ),
            8080
        ).start(Exit.NEVER);
    }
}
