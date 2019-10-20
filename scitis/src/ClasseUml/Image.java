
package ClasseUml;

import java.util.ArrayList;
import java.util.List;
 
public class Image {
    private int iImage;
    private int rangList;
    private List<String> listImage;
    String chemin;
    
    public Image(){
    this.iImage = 0;
    this.listImage = new ArrayList<String>();
    this.chemin ="";
    this.rangList = 0;
    this.initImage();
    }
    
    private void initImage(){
        this.listImage.add("/img/Impossible est un mot que.png");
        this.listImage.add("/img/Je me demande.png");
        this.listImage.add("/img/Les résultats sont.png");
        this.listImage.add("/img/Hmmm Tu me donnes du.png");
    }

    public int getIImage() {
        return this.iImage;
    }
    public int getRangList() {
        return this.rangList;
    }

    public void IncrRangList() {
        this.rangList++;
    }

    public void ReinitIImage() {
        this.iImage=0;
    }
    public void ReinitRangList() {
        this.rangList=0;
    }

    public void IncrIImage() {
        this.iImage++;
    }

    public String GetCheminImage() {
        return this.listImage.get(this.rangList);
    }
    public int getSizeList(){
        return this.listImage.size();
    }
}
