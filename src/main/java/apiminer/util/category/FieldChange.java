package apiminer.util.category;

import apiminer.util.Change;
import gr.uom.java.xmi.*;
import org.eclipse.jgit.revwalk.RevCommit;

import java.util.List;

public class FieldChange extends Change {
    private UMLClass originalClass;
    private UMLClass nextClass;
    private UMLAttribute originalAttribute;
    private UMLAttribute nextAttribute;

    public FieldChange(RevCommit revCommit){
        super(revCommit);
    }

    public UMLClass getOriginalClass() {
        return originalClass;
    }

    protected void setOriginalClass(UMLClass originalClass) {
        this.originalClass = originalClass;
    }

    public UMLClass getNextClass() {
        return nextClass;
    }

    protected void setNextClass(UMLClass nextClass) {
        this.nextClass = nextClass;
    }

    public UMLAttribute getOriginalAttribute() {
        return originalAttribute;
    }

    protected void setOriginalAttribute(UMLAttribute originalAttribute) {
        this.originalAttribute = originalAttribute;
    }

    public UMLAttribute getNextAttribute() {
        return nextAttribute;
    }

    protected void setNextAttribute(UMLAttribute nextAttribute) {
        this.nextAttribute = nextAttribute;
    }

    protected boolean isJavaDoc(UMLAttribute umlAttribute){
        UMLJavadoc javaDoc = umlAttribute.getJavadoc();
        if(javaDoc!=null&&!javaDoc.toString().equals("")){
            return true;
        }
        return false;
    }

    protected boolean isDeprecated(UMLAttribute umlAttribute){
        List<UMLAnnotation> annotationList = umlAttribute.getAnnotations();
        for(UMLAnnotation annotation:annotationList){
            if(annotation.toString().equals("Deprecated")){
                return true;
            }
        }
        return false;
    }
}
