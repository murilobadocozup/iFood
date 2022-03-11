package com.ifoodbackend.validadores;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ValidaSeExiste implements ConstraintValidator<Existe, Object> {

    private String domainAttribute;
    private Class<?> klass;
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(Existe params) {
        klass = params.domainClass();
        domainAttribute = params.fieldName();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = manager.createQuery("select l from " + klass.getName() + " l where " + domainAttribute + " = :pValue");
        query.setParameter("pValue", value);
        List<?> list = query.getResultList();
        Assert.state(list.size() <=1, "Foi encontrado mais de um " + klass	+ " com o atributo" + domainAttribute + " = " + value);

        if (list.size() == 1) {
            return true;
        }

        return false;
    }

}
