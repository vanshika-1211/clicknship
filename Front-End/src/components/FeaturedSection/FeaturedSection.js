import React, { Component } from 'react';
import ProductBlock from '../ProductBlock/ProductBlock';
import './FeaturedSection.css';
import ServerService from '../../API/ServerService';
import axios from 'axios';


class FeaturedSection extends Component {

  state = {
    items : null,
    userData : false,
    loggedIN : null,
    gender : null
  }

  componentDidMount(){

    if(!this.props.personalized){
      console.log('FEATURED PRODUCTS!');
      axios.get('http://0d8c55b48a6d.ngrok.io/api/products/featuredProducts')
        .then(res => {
          console.log(res.data);
          this.setState({items : res.data});
        })
        .catch(err => {
          console.log(err);
        })
    }
    else{
      console.log('PERSONALIZED PRODUCTS!');
      let userID = localStorage.getItem('username');
      if(userID !== null){
        ServerService.fetchDetailsByUserID(userID)
          .then(res => {
            console.log(res);
            this.setState({gender : res.data.gender});
            console.log(this.state.gender);
          }).then(() => {
              if(this.state.gender === 'male'){
                axios.get(`http://0d8c55b48a6d.ngrok.io/api/products/personalisedProducts/Men`)
                  .then(res => {
                    console.log(res);
                    this.setState({items : res.data});
                  })
                  .catch(err => {
                    console.log(err);
                  })
              }
              else if(this.state.gender === 'female'){
                axios.get(`http://0d8c55b48a6d.ngrok.io/api/products/personalisedProducts/Women`)
                  .then(res => {
                    console.log(res);
                    this.setState({items : res.data});
                  })
                  .catch(err => {
                    console.log(err);
                  })
              }
            })
      }
      else{
        axios.get('http://0d8c55b48a6d.ngrok.io/api/products/featuredProducts')
        .then(res => {
          console.log(res);
          this.setState({items : res.data});
        })
        .catch(err => {
          console.log(err);
        })
      }

    }    
    
  }

  render() {

    let data = (
      <h4>Loading...</h4>
    )
    if(this.state.items){
       data = this.state.items.map(item => {
                return <ProductBlock item={item}/>
              })
    }

    if(this.props.personalized&& this.state.items && this.state.gender){
      data = this.state.items.map(item => {
                return <ProductBlock item={item}/>
              })
    }
  
    return (
      <div className='featured'>
        <h3>{this.props.sectionTitle}</h3>
        <h5>
          {this.props.subHead1}<br></br>
          {this.props.subHead2}<br></br>
        </h5>
        
        <div className='featured_block'>
          { data }
        </div>
      </div>
    );
  }
}  

export default FeaturedSection;