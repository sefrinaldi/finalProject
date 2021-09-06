import React, { Component } from 'react'
import { Text, StyleSheet, View } from 'react-native'
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { Home, Login, Splash } from '../pages';

const Stack = createNativeStackNavigator();

class Router extends Component {
    constructor(props) {
        super(props);
        this.state = {  }
    }
    render() { 
        return ( 
            <Stack.Navigator initialRouteName="Splash">
                <Stack.Screen 
                    name="Home"
                    component={Home}
                    options={{ headerShown: false }}
                />
                <Stack.Screen 
                    name="Login"
                    component={Login}
                    options={{ headerShown: false }}
                />
                <Stack.Screen 
                    name="Splash"
                    component={Splash}
                    options={{ headerShown: false }}
                />
            </Stack.Navigator>
         );
    }
}
 
export default Router;

const styles = StyleSheet.create({})
