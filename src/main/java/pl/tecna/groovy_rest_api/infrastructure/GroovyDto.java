package pl.tecna.groovy_rest_api.infrastructure;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class GroovyDto {

    private String scriptName;
    private String description;
    private String groovySourceCode;

}
