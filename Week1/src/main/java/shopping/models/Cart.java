package shopping.models;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="cart_id")
    private Long id;
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
    @OneToMany
    private List<CartElement> shopList;
   
    public Cart(){
        
    }
    public Cart(Long id,User user){
        this.id=id;
        this.user=user;
        this.shopList=new ArrayList<>();
        
    }

    public void setId(Long id) {
        this.id=id;
    }
    public Long getId(){
        return id;
    }
    public void setUser(User user){
        this.user=user;
    }
    public User getUser(){
        return user;
    }
    public void setShopList(List<CartElement> shopList){
        this.shopList=shopList;
    }
    public List<CartElement> getShopList(){
        return shopList;
    }
   

	
    public CartElement addToCart(CartElement element) {
		if (shopList == null) {
			shopList = new ArrayList<CartElement>();
		}
        shopList.add(element);
        return element;
    }
    public CartElement deleteElement(long id){
        for (CartElement x : shopList) {
            if (x.getId()==id) {
                CartElement deleted =x;
                shopList.remove(x);   
                return deleted;             
            }
       }
        return null;
        
    }

    public CartElement deleteElement(CartElement element){
        this.shopList.remove(element);
        return element;
    }


   
}