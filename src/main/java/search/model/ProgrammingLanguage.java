
package search.model;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java bean which describes one object from input json file
 * 
 * @author Raman Skaskevich
 * */
public class ProgrammingLanguage
{
	@JsonProperty(value="Name")
	private String name;
	@JsonProperty(value="Type")
	private String type;
	@JsonProperty(value="Designed by")
	private String designedBy;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getDesignedBy()
	{
		return designedBy;
	}

	public void setDesignedBy(String designedBy)
	{
		this.designedBy = designedBy;
	}
}
