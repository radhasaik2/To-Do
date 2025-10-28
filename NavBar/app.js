import React from 'react';
import { createRoot } from 'react-dom/client';
import { useState } from 'react';

const htmlelement = document.getElementById('root');
const rootreact = createRoot(htmlelement);

const Header = () => {
  return (
    <>
      <header>
        <span>
          <span id='span1' className='home'>Home</span>
          <span id='span2' className='news'>News</span>
          <span id='span3' className='contact'>Contact</span>
          <span id='span4' className='about'>About</span>
        </span>
      </header>
    </>
  );
}

const App = () => {
  return (
    <span>
      <Header />
    </span>
  );
}

rootreact.render(<App />);
