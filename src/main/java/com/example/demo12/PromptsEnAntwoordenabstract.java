package com.example.demo12;

public class PromptsEnAntwoordenabstract implements QueryResolutionStrategy {
    QueryResolutionResult result;
    Boolean engels = false;


    PromptsEnAntwoordenabstract() {

    }

    @Override
    public QueryResolutionResult resolve(QueryResolutionForm ontvangQuery) {
        return null;
    }

    public String gimmeResultsI() {
        if (result != null) {
            return result.getData();
        } else {
            return "";
        }
    }
}


class ChatFilms extends PromptsEnAntwoordenabstract {
    ChatFilms() {
    }

    @Override
    public QueryResolutionResult resolve(QueryResolutionForm ontvangQuery) {

        if (ontvangQuery.getQueryData().equals("Samuel Jackson")) {


            this.result = new QueryResolutionResult("Jules. Samuel Jackson played Jules in Pulp Fiction");
            return result;


        }


        if (ontvangQuery.getQueryData().equals("Uma Thurman")) {

            this.result = new QueryResolutionResult("The Bride. Uma Thurman plays the bride in Kill Bill");
            return result;

        }

        if (ontvangQuery.getQueryData().equals("Tarentino")) {
            this.result = new QueryResolutionResult("Quinten Tarentino is one of the most famous and talented movie directors in the world.");
            return result;
        }
        return result = null;
    }

    public String gimmeResultsI() {
        if (result != null) {
            return result.getData();
        } else {
            return "";
        }
    }
}


    class ChatBoeken extends PromptsEnAntwoordenabstract {

        ChatBoeken() {

        }

        @Override
        public QueryResolutionResult resolve(QueryResolutionForm ontvangQuery) {

            if (ontvangQuery.getQueryData().equals("Ayn Rand")) {
                this.result = new  QueryResolutionResult("Objectivism");
                return result;
            }
            if (ontvangQuery.getQueryData().equals("JRR Tolkien")) {
                this.result = new QueryResolutionResult("Harry Potter");
                return result;
            }

            if (ontvangQuery.getQueryData().equals("Aldus Huxley")) {
                this.result = new QueryResolutionResult("Gimme some Soma.");
                return result;
            }

            return null;
        }

        public String gimmeResultsI() {
            if (result != null) {
                return result.getData();
            } else {
                return "";

            }
        }
    }
