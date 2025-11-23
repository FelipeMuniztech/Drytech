package model;

public class Recurso {
    private int id;
    private String titulo;
    private String autor;
    private Interesses categoria;
    private int usuarioId;
    private String url;
    private String descricao;

    public Recurso(int id) {
        this.id = id;
    }

    public Recurso(int id, String titulo, String autor, Interesses categoria, int usuarioId, String url, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.usuarioId = usuarioId;
        this.url = url;
        this.descricao = descricao;
    }

    public Recurso(String titulo, String autor, Interesses categoria, int usuarioId, String url, String descricao) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.usuarioId = usuarioId;
        this.url = url;
        this.descricao = descricao;
    }

    public Recurso() {

    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public Interesses getCategoria() { return categoria; }
    public void setCategoriaId(Interesses categoria) { this.categoria = categoria; }

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    @Override
    public String toString() {
        return titulo + " - " + categoria.getDescricao();
    }
}
