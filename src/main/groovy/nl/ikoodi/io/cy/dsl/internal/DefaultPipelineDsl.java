package nl.ikoodi.io.cy.dsl.internal;

import groovy.lang.Closure;
import nl.ikoodi.io.cy.dsl.PipelineDsl;
import nl.ikoodi.io.cy.dsl.StageDsl;

public class DefaultPipelineDsl implements PipelineDsl {

    @Override
    public StageDsl stage(final String name, final Closure closure) {
        final StageDsl stage = new DefaultStageDsl(name);
        closure.setDelegate(stage);
        closure.setResolveStrategy(Closure.DELEGATE_FIRST);
        closure.call();
        return stage;
    }

    @Override
    public void echo(final Object value) {
        System.out.print(value);
    }

    @Override
    public void echo(final String format, final Object... values) {
        System.out.printf(format, values);
    }
}