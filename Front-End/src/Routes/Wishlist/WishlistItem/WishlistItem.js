import React, { Component } from 'react';
import '../Wishlist.css';
import imgSRC from '../../../assets/sampleProduct.png';
import { NavLink } from 'react-router-dom';
import ServerService from '../../../API/ServerService';
import axios from 'axios';

class WishlistItem extends Component {

  state = {
    loadedData : null,
  }

  componentDidMount(){
    
    // ServerService.getProductByID(this.props.id)
    axios.get(`http://0d8c55b48a6d.ngrok.io/api/products/productId/${this.props.id}`)
      .then(res => {
        console.log(res);
        this.setState({loadedData : res.data[0]});
      })
      .catch(err => {
        console.log(err);
      })
  }

  removeWish = () => {
    let userId = localStorage.getItem('username');
    let productData = {
      username : userId,
      productId : this.props.id
    }
    console.log(productData);
    
    ServerService.removeFromWishlist(productData)
    .then(response => {
      // alert('Item Deleted!');
      window.location.reload();
    })
    .catch(error => {
      console.log(error);
    })
  }

  render() {
    let showData = (
      <div>
        Loading...
      </div>
    )
    if(this.state.loadedData){
      showData = (
          <div className='wishContainer'>
            <NavLink to={`/product/id/${this.state.loadedData.id}`}>
              <div className='wishlistItemImage'>
                {/* <img src={imgSRC} alt='product_Img'/> */}
                <img src={`data:image/png[jpg];base64,${this.state.loadedData.picByte}`}/>
              </div>
              <div className='alongImg'>
                <h6 className='prodSeller'>{this.state.loadedData.seller}</h6>
                <h5 className='prodName'>{this.state.loadedData.name}</h5>
                <h5 className='prodPrice'>Rs. {this.state.loadedData.price}</h5>
                <h6 className='prodMat'>Material : {this.state.loadedData.material}</h6>  
                <h6 className='prodFit'>Fit : {this.state.loadedData.fit}</h6>
              </div>
            </NavLink>
              {/* <button type="button" className="removeWish btn btn-danger">Remove Item</button> */}
              <i onClick={this.removeWish} className=" removeWish fas fa-trash-alt"></i>
            
          </div>
      )
    }

    return (
      <div className='wishlistItem'>
        {showData}
      </div>
    );
  }
}

export default WishlistItem;