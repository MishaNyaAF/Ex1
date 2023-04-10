package ex1.entity;

public class Raw {

    private Response response;
    private Error error;

    public Raw() {
    }

    public Raw(Response response, Error error) {
        this.response = response;
        this.error = error;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "Raw{" +
                "response=" + response +
                ", error=" + error +
                '}';
    }
}
