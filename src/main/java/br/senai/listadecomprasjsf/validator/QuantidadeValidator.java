package br.senai.listadecomprasjsf.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Map;

@FacesValidator(value = "QuantidadeValidator")
public class QuantidadeValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        if (o == null || !o.toString().matches("^(0*[1-9][0-9]*(\\.[0-9]+)?|0+\\.[0-9]*[1-9][0-9]*)$")){
            Map<String, Object> atributos = uiComponent.getAttributes();
            String nomeCampo = (String) atributos.getOrDefault("quantidade-item", "Quantidade");
            FacesMessage msg = new FacesMessage(nomeCampo + ": Valor informado é inválido","Erro de validação");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
