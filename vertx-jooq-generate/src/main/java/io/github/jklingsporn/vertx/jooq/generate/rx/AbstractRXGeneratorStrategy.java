package io.github.jklingsporn.vertx.jooq.generate.rx;

import io.github.jklingsporn.vertx.jooq.generate.AbstractVertxGeneratorStrategy;
import org.jooq.util.JavaWriter;

/**
 * Created by jensklingsporn on 06.02.18.
 */
abstract class AbstractRXGeneratorStrategy extends AbstractVertxGeneratorStrategy {


    @Override
    public void writeDAOImports(JavaWriter out) {
        out.println("import io.reactivex.Completable;");
        out.println("import io.reactivex.Observable;");
        out.println("import io.reactivex.Single;");
        out.println("import java.util.Optional;");
    }

    @Override
    public String getFQVertxName() {
        return "io.vertx.reactivex.core.Vertx";
    }

    @Override
    public String renderFindOneType(String pType) {
        return String.format("Single<Optional<%s>>",pType);
    }

    @Override
    public String renderFindManyType(String pType) {
        return String.format("Single<List<%s>>",pType);
    }

    @Override
    public String renderExecType() {
        return "Single<Integer>";
    }

    @Override
    public String renderInsertReturningType(String tType) {
        return String.format("Single<%s>", tType);
    }

    @Override
    public String renderDAOInterface(String rType, String pType, String tType) {
        return String.format("io.github.jklingsporn.vertx.jooq.rx.VertxDAO<%s,%s,%s>",rType,pType,tType);
    }

}
