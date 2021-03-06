package apiminer.internal.analysis.category;

import apiminer.Change;
import apiminer.internal.util.UtilTools;
import gr.uom.java.xmi.UMLAnnotation;
import gr.uom.java.xmi.UMLClass;
import gr.uom.java.xmi.UMLJavadoc;
import org.eclipse.jgit.revwalk.RevCommit;

import java.util.List;

public class TypeChange extends Change {
    private UMLClass originalClass;
    private UMLClass nextClass;

    public TypeChange(RevCommit revCommit){
        super(revCommit);
    }

    protected void setOriginalClass(UMLClass originalClass){
        this.originalClass = originalClass;
    }
    protected void setNextClass(UMLClass nextClass){
        this.nextClass = nextClass;
    }

    public UMLClass getOriginalClass(){
        return originalClass;
    }

    public UMLClass getNextClass(){
        return nextClass;
    }


    protected boolean isJavaDoc(UMLClass umlClass){
        UMLJavadoc javaDoc = umlClass.getJavadoc();
        if(javaDoc!=null&&!javaDoc.toString().equals("")){
            return true;
        }
        return false;
    }

    protected boolean checkDeprecated(UMLClass umlClass){
        return UtilTools.isDeprecated(umlClass.getAnnotations());
    }
}
