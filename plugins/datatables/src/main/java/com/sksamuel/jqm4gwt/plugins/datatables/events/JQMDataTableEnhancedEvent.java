package com.sksamuel.jqm4gwt.plugins.datatables.events;

import com.google.gwt.event.logical.shared.HasAttachHandlers;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class JQMDataTableEnhancedEvent extends GwtEvent<JQMDataTableEnhancedEvent.Handler> {

    public interface Handler extends EventHandler {
        void onBeforeEnhance(JQMDataTableEnhancedEvent event);
        void onEnhanced(JQMDataTableEnhancedEvent event);
    }

    private final boolean before;

    public JQMDataTableEnhancedEvent(boolean before) {
        this.before = before;
    }

    static Type<JQMDataTableEnhancedEvent.Handler> TYPE;

    /**
     * Fires an {@link JQMDataTableEnhancedEvent} on all registered handlers in the handler source.
     *
     * @param <S> The handler source type
     * @param source - the source of the handlers
     */
    public static <S extends HasAttachHandlers> void fire(S source, boolean before) {
        if (TYPE != null) {
            JQMDataTableEnhancedEvent event = new JQMDataTableEnhancedEvent(before);
            source.fireEvent(event);
        }
    }

    public static Type<JQMDataTableEnhancedEvent.Handler> getType() {
      if (TYPE == null) {
          TYPE = new Type<JQMDataTableEnhancedEvent.Handler>();
      }
      return TYPE;
    }

    @Override
    public final Type<JQMDataTableEnhancedEvent.Handler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(JQMDataTableEnhancedEvent.Handler handler) {
        if (this.before) handler.onBeforeEnhance(this);
        else handler.onEnhanced(this);
    }

}
