import React, { Component } from 'react';
import Navbar from '../../components/Navbar/Navbar';
import loadSrc from '../../assets/loader2.gif';
import './Wishlist.css';
import { NavLink, Redirect } from 'react-router-dom';
import WishlistItem from './WishlistItem/WishlistItem';
import emptyWishSRC from '../../assets/emptyWishlist.png';
import ServerService from '../../API/ServerService';

class Wishlist extends Component {

  state = {
    list : null,
    isEmpty : null,
    userName : 'Username',
    redirect : null,
  }

  componentDidMount(){

    let userId = localStorage.getItem('username');

    ServerService.fetchDetailsByUserID(userId)
      .then(res => {
        console.log(res);
        this.setState({userName : res.data.firstName});
      })
      .catch(err => {
        console.log(err);
      })
    
    ServerService.fetchWishlistDetailsByID(userId)
      .then(res => {
        console.log(res);
        if(res.data.length === 0){
          this.setState({isEmpty : true})
        }
        else{
          this.setState({list : res.data});
        }
      })
      .catch(err => {
        console.log(err);
      })

    if(userId === null){
      this.setState({redirect : '/'});
    }
  }

  logOut = (e) => {
    localStorage.clear();
    window.location.reload();
  }

  render() {

    if(this.state.redirect){
      return <Redirect to={this.state.redirect}/>
    }

    let data = (
      <div className='wishLoader'>
        <img src={loadSrc} alt='Loader'/>
      </div>
    )
    if(this.state.list){
      data = (
        <div className='wishlistDisplay'>
          {
            this.state.list.map(id => {
              return <WishlistItem id={id}/>
            })
          }
        </div>
      )
    }
    if(this.state.isEmpty){
      data = (
        <div className='wishLoader'>
          <img className='emptyWishlistImg' src={emptyWishSRC} alt='emptyWishlist'/>
        </div>
      )
    }

    return (
      <div>
        <Navbar shadow={true}/>
        <div className='wishlistContainer'>
          
          <div className='accountBlock'>
            
            <div className='user'>
              <i class="fas fa-2x fa-user-circle"></i>
              <div className='helloUser'>
                <h6 className='hello'>Hello,</h6>
                <h6 className='username'>{this.state.userName}</h6>
              </div>
            </div>
            
            <div className='accountLinks'>
              <NavLink to='/user'>
                <i class="fas fa-user-cog"></i>
                Profile Details
              </NavLink>
              <NavLink to='/wishlist'>
                <i class="fas fa-heart"></i>
                My Wishlist
              </NavLink>
              <NavLink to='/cart'>
                <i class="fas fa-shopping-cart"></i>
                My Cart
              </NavLink>
            </div>

            <div className='logoutBtn'>
              <button type="button" onClick={this.logOut} class="btn btn-dark logoutButton">
                Logout
              </button>
            </div>

          </div>
          <div className='rightDisplay'>
            <h5 className='myWishlist'>My Wishlist</h5>
            {data}
          </div>
        </div>
      </div>
    );
  }
}

export default Wishlist;