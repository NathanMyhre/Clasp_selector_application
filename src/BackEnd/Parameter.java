package BackEnd;

/** Parameter is the abstract container for all parameters that pertain to dental
 * health. Must implement setValue method in order to initialize paramValue
 *
 */
public abstract class Parameter<T> {
    public String paramName;
    public T paramValue;
    //Bug: need a solution for value
    //Testing needs to handle getting the proper value

    //Bug: need to throw an error if newParameter can't be initialized.
    public static Parameter newParameter(String name, String val) {
        Parameter newParameter = null;
        if ("stressrelease".equals(name)) {
            newParameter = new StressReleaseNeeded(name, val);
        } else if ("surveylineclass".equals(name)) {
            newParameter = new SurveyLineClassification(name, val);
        } else if ("retentiveundercut".equals(name)) {
            newParameter = new RetentiveUndercut(name, val);
        } else if ("occlusion".equals(name)) {
            newParameter = new Occlusion(name, val);
        } else if ("softtissueundercut".equals(name)) {
            newParameter = new SoftTissueUndercut(name, val);
        } else if ("bucalvestibule2mm".equals(name)) {
            newParameter = new BucalVestibule2mm(name, val);
        } else if ("estheticconcern".equals(name)) {
            newParameter = new EstheticConcern(name, val);
        } else if ("toothtype".equals(name)) {
            newParameter = new ToothType(name, val);
        } else {
            //Bug: throw error/make a new algorithm if cannot construct individual parameter.
        }
        return newParameter;
    }

    //Bug: need a better equals method for Parameter in the future.
    public boolean equalTo( Parameter p) {
        if (this.paramValue == null || this.paramName ==null) {
            return false;
        } else if (p.paramName == null || p.paramValue == null) {
            return false;
        }
        return (this.paramName.equals(p.paramName)
                && (this.paramValue.equals(p.paramValue)));
    }
}

class StressReleaseNeeded extends Parameter {
    public StressReleaseNeeded(String name, String value) {
        paramName = name;
        paramValue = Boolean.parseBoolean(value);
    }
}

class SurveyLineClassification extends Parameter {
    public SurveyLineClassification(String name, String value) {
        paramName = name;
        paramValue = Integer.parseInt(value);
    }
}

class RetentiveUndercut extends Parameter {
    public RetentiveUndercut(String name, String value) {
        paramName = name;
        paramValue = Float.parseFloat(value);
    }
}

class Occlusion extends Parameter {
    public Occlusion(String name, String value){
        paramName = name;
        paramValue = value;
    }
}

class SoftTissueUndercut extends Parameter {
    public SoftTissueUndercut(String name, String value){
        paramName = name;
        paramValue = Boolean.parseBoolean(value);
    }
}

class BucalVestibule2mm extends Parameter {
    public BucalVestibule2mm(String name, String value) {
        paramName = name;
        paramValue = Boolean.parseBoolean(value);
    }
}

class EstheticConcern extends Parameter {
    public EstheticConcern(String name, String value) {
        paramName = name;
        paramValue = Boolean.parseBoolean(value);
    }
}

class ToothType extends Parameter {
    public ToothType(String name, String value) {
        paramName = name;
        paramValue = value;
    }
}