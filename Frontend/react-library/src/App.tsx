import React from 'react';
import './App.css';
import { HomePage } from './layouts/HomePage/HomePage';
import { Navbar } from './layouts/NavBarAndFooter/NavBar';
import { SearchBooksPage } from './layouts/SearchBooksPage/SearchBooksPage';
import { Footer } from './layouts/HomePage/components/Footer';

export const App = () => {
  return (
    <div>
   {/* <HomePage /> */}
   <Navbar/>
   <SearchBooksPage />
   <Footer />
   </div>
  );
}


