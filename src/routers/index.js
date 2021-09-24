import React, { Component } from 'react'
import { Text, StyleSheet, View } from 'react-native'
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { Home, Inbox, Login, Profile, Register, Splash, History, Tagihan, ChangePassword, EditProfile } from '../pages';
import { BottomNavigator } from '../components';

const Stack = createNativeStackNavigator();
const Tab = createBottomTabNavigator();

const MyTabs = () => {
    return (
        <Tab.Navigator tabBar={props => <BottomNavigator {...props} />}>
            <Tab.Screen name="Home" component={Home} options={{ headerShown: false }} />
            <Tab.Screen name="History" component={History} options={{ headerShown: false }} />
            <Tab.Screen name="Tagihan" component={Tagihan} />
            <Tab.Screen name="Inbox" component={Inbox} options={{ headerShown: false }} />
            <Tab.Screen name="Profile" component={Profile} options={{ headerShown: false }} />
        </Tab.Navigator>
    );
}

class Router extends Component {
    constructor(props) {
        super(props);
        this.state = {  }
    }
    render() { 
        return ( 
            <Stack.Navigator initialRouteName="Splash">
                <Stack.Screen 
                    name="MyTabs"
                    component={MyTabs}
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
                <Stack.Screen 
                    name="Register"
                    component={Register}
                    options={{ headerShown: false }}
                />
                <Stack.Screen 
                    name="Profile"
                    component={Profile}
                    options={{ headerShown: false }}
                />
                <Stack.Screen 
                    name="ChangePassword"
                    component={ChangePassword}
                    options={{ headerShown: false}}
                />
                <Stack.Screen 
                    name="EditProfile"
                    component={EditProfile}
                    options={{ headerShown: false}}
                />
            </Stack.Navigator>
         );
    }
}
 
export default Router;

const styles = StyleSheet.create({})
