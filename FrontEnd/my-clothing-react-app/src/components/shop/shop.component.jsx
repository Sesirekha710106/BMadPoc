import React from "react";
import SHOP_DATA from "./shop.data";
import { CollectionPreview } from "../collection-preview/collection-preview.component";


class Shop extends React.Component{
    constructor(){
        super();
        this.state = {
            collections : SHOP_DATA
        }
        
    }
    render(){
        const { collections } = this.state;
       return <div className="shop-page">{
                collections.map(({key, ...otherCollectionProps}) => {
                   return  <CollectionPreview key={key} {...otherCollectionProps}/>
                })}
            </div>

    }
}

export default Shop;