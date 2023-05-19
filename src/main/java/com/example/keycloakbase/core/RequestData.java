package com.example.keycloakbase.core;

public class RequestData {
    protected RequestData(RequestDataBuilder<?, ?> b) {
    }

    public RequestData() {
    }

    public static RequestDataBuilder<?, ?> builder() {
        return new RequestDataBuilderImpl();
    }

    private static final class RequestDataBuilderImpl extends RequestDataBuilder<RequestData, RequestDataBuilderImpl> {
        private RequestDataBuilderImpl() {
        }

        protected RequestDataBuilderImpl self() {
            return this;
        }

        public RequestData build() {
            return new RequestData(this);
        }
    }

    public abstract static class RequestDataBuilder<C extends RequestData, B extends RequestDataBuilder<C, B>> {
        public RequestDataBuilder() {
        }

        protected abstract B self();

        public abstract C build();

        public String toString() {
            return "RequestData.RequestDataBuilder()";
        }
    }
}
