
public class Item 
{
	private Tipo tipo;
	private String descricao;
	
	public Item( String _descricao )
	{
		this.tipo = null;
		this.descricao = _descricao;
	}
	
	public Item( String _descricao, Tipo _tipo )
	{
		this.tipo = _tipo;
		this.descricao = _descricao;
	}
	
	public Tipo getTipo() 
	{
		return this.tipo;
	}
	
	public void setTipo(Tipo _tipo) 
	{
		this.tipo = _tipo;
	}
	
	public String getDescricao() 
	{
		return descricao;
	}
	public void setDescricao(String _descricao) 
	{
		this.descricao = _descricao;
	}
	
	@Override
	public String toString() 
	{
		return "(" + this.getDescricao() + ";" +  this.getTipo() + ")";
	}
}
